<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <!DOCTYPE html>
  <html>
    <head>
      <meta charset="ISO-8859-1">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <!-- Bootstrap CSS -->
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
      <link rel="stylesheet" href="style.css">
      <link rel="preconnect" href="https://fonts.googleapis.com">
      <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
      <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
      <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
      <link href="https://fonts.googleapis.com/css2?family=Hind+Siliguri:wght@600&display=swap" rel="stylesheet" />
      <title>Login
      </title>
    </head>
    <body class="background-white">
      <nav class="navbar navbar-light">
        <div class="container-fluid">
          <span class="navbar-text" >
            Product Management Tools
          </span>
        </div>
      </nav>
      <div class="container-fluid col-lg-6 col-md-6 col-sm-6">
        <div class="login-container">
          <div class="login-header-footer" id="header-section">
            <div class="header-content">
              <b>Login
              </b>
            </div>
          </div>
          <div class="background-bl-gr" id="middle-section">
            <form action="Authenticator" method="post">
              <div class="row mb-3">
                <label for="inputEmail3" class="col-sm-2 col-form-label">Username
                </label>
                <div class="col-sm-10" >
                  <input type="email" class="form-control" id="inputEmail3" name="username" placeholder="Enter Your Username">
                </div>
              </div>
              <div class="row mb-3">
                <label for="inputPassword3" class="col-sm-2 col-form-label" >Password
                </label>
                <div class="col-sm-10">
                  <input type="password" class="form-control" id="inputPassword3" name = "mypassword" placeholder="Enter Your Password">
                </div>
              </div>
              <section id="forgot-password">
                <a class="forgot-text" href="password.jsp">forgotten your password?
                </a>               
              </section>
          </div>
        	<div class="footer-section login-header-footer">
        		<input type="submit" value="Login"> 
        	</div>
        </form>
        </div>
      </div>
      
    </body>
  </html>
