<%-- 
   Document   : index
   Created on : May 14, 2017, 8:57:36 AM
   Author     : Niru
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="SITE_URL" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>

<%@include file="../header.jsp" %>
<br/>






<div class="pull-left" id="top-dialog" >


    <select name="cid" class="form-control" id="cid" class="col-md-4"> 
        <option value="">Search name</option>
        <c:forEach var="customers" items="${customers}">
            <option value="${customers.id}">${customers.name}</option>
        </c:forEach>

    </select> 


    <button type="submit" class="btn btn-info" id="btn-search"><span class="glyphicon glyphicon-search"></span></button>

</div>

<br><br>

<table id="result" class="table table-bordered table-sthiped table-hover">
    <tr>
        <th>S.No</th>
        <th>Name</th>
        <th>Account No</th>
        <th>Balance</th>
    </tr>
    <c:forEach var="balance" items="${balance}"  varStatus="counter">
        <tr id="tr">

            <td>${counter.count}</td>
            <td>${balance.customer.name}</td>
            <td>${balance.customer.account.account_no}</td>
            <td>${balance.amount}</td>
        </tr>
    </c:forEach>
</table>
<a href="${SITE_URL}/admin/pageRequest/page=1">1</a>   
<a href="${SITE_URL}/admin/pageRequest/page=2">2</a>   
<a href="${SITE_URL}/admin/pageRequest/page=3">3</a>  
</body>
<script>
//    var app = angular.module("myapp", ["ngRoute"]);
//    app.config(function ($routeProvier) {
//        $routeProvider
//
//                .when("/london", {
//                    templateUrl: "London.html",
//                    contholler: "londonCthl"
//                })
//                .when("/paris", {
//                    templateUrl: "paris.html",
//                    contholler: "parisCthl"
//
//                });
//    });
//    app.contholler("londonCthl", function ($scope) {
//        $scope.msg = "I love London";
//
//    });
//    app.contholler("parisCthl", function ($scope) {
//        $scope.msg = "I love Paris";
//    });



////<!--    $(document).on("ready", function () {
//
//  ///      $("#btn-search").on("click", function () {
//            var cid=$("#cid").val();
//           // alert(cid);
//            $.getJSON("**/api/list",{cid:cid}, function(data){
//               //alert(data.id) ;
//               if(data.id==cid){
//                   //alert(data.id);
//                   //$("#name").html(data.name).css({"color":" #5bc0de","font-weight":"bold","font-size":"20px"});
//                 $(this).css({"background-color":"lime"});
//               }
//            });
//            return false;
//        });
//    });-->
//           
    $(document).on("ready", function () {
        $("#btn-search").on("click", function () {
            var  cid=$("#cid").val();
            $.get("**/api/list",{cid:cid},function(data){
                if(data.id==cid){
                   // alert(data.id);
                     $("#tr").css({"background-color":"lime"});
                    
                }
                
            });
         


            return false;

        });

    });

</script>


</html>
