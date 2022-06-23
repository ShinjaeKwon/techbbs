<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>Tech BBS</title>
    <link rel="stylesheet" href="/css/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="/css/navbar_techandall.css">
</head>

<body bgcolor="#333333">
<div class="container">
    <div>
        <label class="mobile_menu" for="mobile_menu">
            <span>Menu</span>
        </label>
        <input id="mobile_menu" type="checkbox">
        <ul class="nav">
            <li><a href="#"><i class="icon-home icon-large"></i></a></li>


            <!----- Full Drop Down Name ---->
            <li class="dropdown"><a href="#">blueb.co.kr</a>
                <!----- Full Drop Down Name Ends Here ---->

                <!----- Full Drop Down Contents  Starts Here---->

                <div class="fulldrop">
                    <div class="column">
                        <h3>menu1</h3>
                        <ul>
                            <li><a href="#">Tech ANd All</a></li>
                            <li><a href="#">Web Designs</a></li>
                            <li><a href="#">PSD</a></li>
                            <li><a href="#">Scripts</a></li>
                        </ul>
                    </div>


                    <div class="column">
                        <h3>Menu Header</h3>
                        <ul>
                            <li><a href="#">Tech ANd All</a></li>
                            <li><a href="#">Web Designs</a></li>
                            <li><a href="#">PSD</a></li>
                            <li><a href="#">Scripts</a></li>
                        </ul>
                    </div>


                    <div class="column">
                        <h3>Menu Header</h3>
                        <ul>
                            <li><a href="#">Tech ANd All</a></li>
                            <li><a href="#">Web Designs</a></li>
                            <li><a href="#">PSD</a></li>
                            <li><a href="#">Scripts</a></li>
                        </ul>
                    </div>


                    <div class="column">
                        <h3>Menu Header</h3>
                        <ul>
                            <li><a href="#">Tech ANd All</a></li>
                            <li><a href="#">Web Designs</a></li>
                            <li><a href="#">PSD</a></li>
                            <li><a href="#">Scripts</a></li>
                        </ul>
                    </div>


                    <div class="column">
                        <h3>Menu Header</h3>
                        <ul>
                            <li><a href="#">Tech ANd All</a></li>
                            <li><a href="#">Web Designs</a></li>
                            <li><a href="#">PSD</a></li>
                            <li><a href="#">Scripts</a></li>
                        </ul>
                    </div>


                    <div class="column">
                        <h3>Menu Header</h3>
                        <ul>
                            <li><a href="#">Tech ANd All</a></li>
                            <li><a href="#">Web Designs</a></li>
                            <li><a href="#">PSD</a></li>
                            <li><a href="#">Scripts</a></li>
                        </ul>
                    </div>
                </div>
            </li>
            <!----- Full Drop Down Contents  Ends  Here---->


            <!----- Full Drop Down Name ---->
            <li class="dropdown"><a href="#">Drop Down Menu 2</a>
                <!----- Full Drop Down Name Ends Here ---->

                <!----- Full Drop Down Contents  Starts Here---->

                <div class="fulldrop">
                    <div class="column">
                        menu2
                    </div>
            </li>
            <!----- Full Drop Down Contents  Ends  Here---->


            <!----- Regular Menu Button ---->
            <li><a href="#"> Web Designs</a></li>
            <!----- Regular Menu Button Ends---->


            <!----- Regular Menu Button ---->
            <li><a href="#"> LifeStyle</a></li>
            <!----- Regular Menu Button Ends---->


            <!----- Regular Menu Button ---->
            <li><a href="#"> About</a></li>
            <!----- Regular Menu Button Ends---->

            <!----- Regular Menu Button ---->
            <li><a href="#"> Contact</a></li>
            <!----- Regular Menu Button Ends---->


            <!----- Search Form Starts---->
            <li class="search">
                <form action="Search.php">
                    <i class="icon-search icon-large"></i><input type="text">
                </form>
            </li>
            <!----- Search Form Ends ---->


        </ul>
    </div>
</div>
</body>
</html>