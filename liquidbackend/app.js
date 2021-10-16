var crypto = require('crypto');
var express = require('express');
var mysql = require('mysql');
var bodyParser = require('body-parser');

const e = require('express');

var myLocalhost = 'localhost'

var con = mysql.createConnection({
    host: myLocalhost,
    user: 'root',
    password: '',
    database: 'liquiddb'
});

con.connect(function(err) {
    if (err) throw err;
    console.log("MySql DB Connection successful")
});

var getRandomString = function(length) {
    return crypto.randomBytes(Math.ceil(length/2))
    .toString('hex')
    .slice(0, length)
}

var sha512 = function(password, salt) {
    var hash = crypto.createHmac('sha512', salt);
    hash.update(password);
    var value = hash.digest('hex')
    return {
        salt: salt,
        passwordHash: value
    }
};

function saltHashPassword(userPassword) {
    var salt = getRandomString(16)
    var passwordData = sha512(userPassword, salt)
    return passwordData
}

var app = express()
app.use(bodyParser.json())
app.use(bodyParser.urlencoded({extended: true}))

app.post("/register", (req,res,next)=> {

    var post_data = req.body

    var name = post_data.name;
    var email = post_data.email;

    var normal_password = post_data.password;

    var hash_data = saltHashPassword(normal_password);

    var password = hash_data.passwordHash;
    var salt = hash_data.salt;

    con.query('SELECT * FROM ACCOUNT WHERE EMAIL = ?',[email], function(err,result,fields) {
        con.on("error",function(err) {
            console.log("con.query line 77 error: ",err.toString);
        })
        if (result && result.length)
            res.json("User already exists");
        else {
            try {
                con.query('INSERT INTO `account` ' + 
            'VALUES (?,?,?,?)',[name,email,password,salt], function(err,result,fields) {
                con.on("error",function(err){
                    console.log("MYSQL related error: ",err);
                })
                res.json("Registration Successful!")  
        })
            } catch (error)
            {
                console.log("exception hogya ree: ", error);
            }
    }
}) })

app.post("/login", (req,res,next)=> {

    var post_data = req.body;

    var email = post_data.email;
    var password = post_data.password;

    con.query('SELECT * FROM user WHERE EMAIL=?',[email], function(err,result,fields) {
        con.on("error", function(err) {
            console.log("con query line 55 error: ",err);
        });
        if (result && result.length) {
            var salt = result[0].salt;
            var encrypted_password = result[0].encrypted_password
            var hashed_password = sha512(password,salt).passwordHash;
            if (encrypted_password == hashed_password)
                res.json("Login successful!");
            else {
                res.json("Wrong Password!");
            }
        }
        else {
            res.json("User doesn't exist!");
        }
    })

})


app.listen(3000, ()=> {
    console.log("Listening to port 3000!");
});
