<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Hind+Siliguri:wght@600&display=swap" rel="stylesheet" />

    <title>login</title>
  </head>
  <body>
    <nav class="navbar navbar-light">
      <div class="container-fluid">
        <span class="navbar-text">
          Product Management Tools
        </span>
      </div>
    </nav>
        <div class="container-fluid col-lg-6 col-md-6 col-sm-6" style="border:solid rgb(84, 190, 247); border-radius:1px;
        border-width:1.5px; ">
            <div id="header-section">
            <div class="row"style="border-bottom:solid  rgb(84, 190, 247); border-width:1.5px; margin-top:20px;font-size:25px; text-align:center;" >
                <b>PMS</b>
            </div>
            </div>
            <div id="middle-section">
            <form action="Password" method="post">
                <div class="row mb-3" style= "margin-top:1rem;">
                  <label for="inputEmail3" class="col-sm-2 col-form-label">Username</label>
                  <div class="col-sm-10">
                    <input type="email" class="form-control" id="inputEmail3" name="myusername" placeholder="Enter your username">
                  </div>
                </div>
                <input type="submit" value="Submit"class="btn btn-primary" >
                
              </form>
              <br>
              <br>
              <div class="row mb-3">
                <label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
                <div class="col-sm-10">
                  <input type="text" class="form-control" id="inputPassword3" value="<%=request.getAttribute("password") %>" placeholder="Your password will be displayed here">
                </div>
                <br>
               <section id="forgot-password" style="text-align:center; margin:35px; padding-bottom:1.5rem;">
                  <a href="index.jsp" >Login Again?</a>
                </section>
              </div>
              </div>
                  
        </div>
    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  </body>
</html>