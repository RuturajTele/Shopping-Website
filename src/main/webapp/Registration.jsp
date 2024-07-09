<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>CodePen - Glassmorphism login Form Tutorial in html css</title>
  <!-- Design by foolishdeveloper.com -->
  <link rel="preconnect" href="https://fonts.gstatic.com">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
  <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600&display=swap" rel="stylesheet">
  <!--Stylesheet-->
  <style media="screen">
    *,
    *:before,
    *:after{
        padding: 0;
        margin: 0;
        box-sizing: border-box;
    }
    body{
        background-color: #080710;
    }
    .background{
        width: 430px;
        height: 520px;
        position: absolute;
        transform: translate(-50%,-50%);
        left: 50%;
        top: 50%;
    }
    .background .shape{
        height: 200px;
        width: 200px;
        position: absolute;
        border-radius: 50%;
    }
    .shape:first-child{
        background: linear-gradient(
            #1845ad,
            #23a2f6
        );
        left: -80px;
        top: -80px;
    }
    .shape:last-child{
        background: linear-gradient(
            to right,
            #ff512f,
            #f09819
        );
        right: -30px;
        bottom: -80px;
    }
    form{
        height: 520px;
        width: 400px;
        background-color: rgba(255,255,255,0.13);
        position: absolute;
        transform: translate(-50%,-50%);
        top: 50%;
        left: 50%;
        border-radius: 10px;
        backdrop-filter: blur(10px);
        border: 2px solid rgba(255,255,255,0.1);
        box-shadow: 0 0 40px rgba(8,7,16,0.6);
        padding: 50px 35px;
    }
    form *{
        font-family: 'Poppins',sans-serif;
        color: #ffffff;
        letter-spacing: 0.5px;
        outline: none;
        border: none;
    }
    form h3{
        font-size: 32px;
        font-weight: 500;
        line-height: 42px;
        text-align: center;
    }
    label{
        display: block;
        margin-top: 30px;
        font-size: 16px;
        font-weight: 500;
    }
    input{
        display: block;
        height: 50px;
        width: 100%;
        background-color: rgba(255,255,255,0.07);
        border-radius: 3px;
        padding: 0 10px;
        margin-top: 8px;
        font-size: 14px;
        font-weight: 300;
    }
    ::placeholder{
        color: #e5e5e5;
    }
    button{
        margin-top: 50px;
        width: 100%;
        background-color: #ffffff;
        color: #080710;
        padding: 15px 0;
        font-size: 18px;
        font-weight: 600;
        border-radius: 5px;
        cursor: pointer;
    }
    .social{
      margin-top: 30px;
      display: flex;
    }
    .social div{
      background: red;
      width: 150px;
      border-radius: 3px;
      padding: 5px 10px 10px 5px;
      background-color: rgba(255,255,255,0.27);
      color: #eaf0fb;
      text-align: center;
    }
    .social div:hover{
      background-color: rgba(255,255,255,0.47);
    }
    .social .fb{
      margin-left: 25px;
    }
    .social i{
      margin-right: 4px;
    }
  </style>
</head>
<body>
  <div class="background">
    <div class="shape"></div>
    <div class="shape"></div>
  </div>
<form id="registrationForm" action="RegistrationController" onsubmit="return validateForm()">
    <table>
        <tr>
            <td>Enter email id</td>
            <td><input type="email" id="emailId" name="emailId" required></td>
        </tr>
        <tr>
            <td>Enter Customer name</td>
            <td><input type="text" id="custName" name="custName" required></td>
        </tr>
        <tr>
            <td>Enter User name</td>
            <td><input type="text" id="userName" name="userName" required></td>
        </tr>
        <tr>
            <td>Enter Mobile number</td>
            <td><input type="text" id="mobNo" name="mobNo" required></td>
        </tr>
        <tr>
            <td>Enter valid password</td>
            <td><input type="password" id="password" name="password" required></td>
        </tr>
        <tr>
            <td><input type="submit" value="Register Here"></td>
        </tr>
    </table>
</form>

<script>
    function validateForm() {
        var email = document.getElementById("emailId").value;
        var custName = document.getElementById("custName").value;
        var userName = document.getElementById("userName").value;
        var mobNo = document.getElementById("mobNo").value;
        var password = document.getElementById("password").value;

        // Simple email validation
        var emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!emailPattern.test(email)) {
            alert("Please enter a valid email address.");
            return false;
        }

        // Check if customer name is not empty
        if (custName.trim() === "") {
            alert("Please enter your name.");
            return false;
        }

        // Check if username is not empty
        if (userName.trim() === "") {
            alert("Please enter a username.");
            return false;
        }

        // Simple mobile number validation
        var mobilePattern = /^\d{10}$/;
        if (!mobilePattern.test(mobNo)) {
            alert("Please enter a 10-digit mobile number.");
            return false;
        }

        // Check if password meets minimum length requirement
        if (password.length < 8) {
            alert("Password must be at least 8 characters long.");
            return false;
        }

        // If all validations pass, return true to submit the form
        return true;
    }
</script>
</body>
</html>