
<%@include file="../../header.jsp" %>
<div>
    <div class="col-md-4">
        <select id="cid" class="form-control">
            <option value="">Select name to Search</option>
            <c:forEach var="customer" items="${customers}">

                <option value="${customer.id}">${customer.name}</option>
            </c:forEach>

        </select>
    </div>
    <button type="submit" id="btn-search" class="btn btn-success btn-sm">Search</button>
    
    <br>
    <br>
    
    <form   method="post" action="${SITE_URL}/account/save" id="customer-form">


        <fieldset>
            <legend>Account Information</legend>
            <div class="form-group">
                <label class="col-md-1 control-label" for="name">Account Number:</label>  
                <div class="col-md-4">
                    <div id="account_number"></div>
                    <span class="help-block"> </span>  
                </div>
                <label class="col-md-1 control-label" for="name">Account type:</label>  
                <div class="col-md-4">
                    <div id="account_type"></div>
                </div>
                <br/><br/><br/><br/>



                <label class="col-md-1  control-label" for="id_no" >Identification No: </label>  
                <div class="col-md-4">
                    <div id="id_no"></div>
                    <span class="help-block"> </span>  
                </div>
                <label class="col-md-1  control-label" for="date" >Account opened Date: </label>  
                <div class="col-md-4">
                    <div id="date"></div>
                    <span class="help-block"> </span>  
                </div>
            </div>



        </fieldset>
        <br/><br/>
        <fieldset>
            <legend>Personal Information</legend>
            <div class="form-group">
                <label class="col-md-1 control-label" for="name">Name:</label>  
                <div class="col-md-4">
                    <div id="name"></div>
                    <span class="help-block"> </span>  
                </div>
                <label class="col-md-1 control-label" for="address">Address:</label>  
                <div class="col-md-4">
                    <div id="address"></div>
                    <span class="help-block"> </span>  
                </div>
                <br/><br/><br/>



                <label class="col-md-1  control-label" for="email" >Email: </label>  
                <div class="col-md-4">
                    <div id="email"></div>
                    <span class="help-block"> </span>  
                </div>

                <label class="col-md-1  control-label" for="name" >Gender :</label>  
                <div class="col-md-4">
                    <div id="gender"></div>
                </div>
                <br/><br/><br/>

                <label class="col-md-1  control-label" for="name" >Contact_no:</label>  
                <div class="col-md-4">
                    <div id="contact_no"></div>
                    <span class="help-block"> </span>  
                </div>
                <br/><br/><br/><br/>
                <label class="col-md-1  control-label" for="status" >Status:</label>  
                <div class="col-md-4">
                    <div id="status"></div>
                    <span class="help-block"> </span>  
                </div>
            </div>
        </fieldset>
        <br/>


    </form>

</div>
<script>
    $(document).on("ready", function () {
        // alert("hello");
        var cid, cname;
        $("#cid").on("change", function () {
            cid = $(this).val();
            cname = $(this).find('option:selected').text();
        });
        $("#btn-search").on("click", function () {
            //alert("hello");

            //alert(cname);
            $.getJSON("**/api/list", {cid: cid}, function (data) {
                //alert(data.name+" "+data.address);
                $("#account_number").html(data.account.account_no).css({"color": " #5bc0de", "font-weight": "bold", "font-size": "20px"});

                $("#account_type").html(data.account.account_type).css({"color": " #5bc0de", "font-weight": "bold", "font-size": "20px"});
                $("#id_no").html(data.account.identification_id_no).css({"color": " #5bc0de", "font-weight": "bold", "font-size": "20px"});
                $("#date").html(data.account.date).css({"color": " #5bc0de", "font-weight": "bold", "font-size": "20px"});
                $("#name").html(data.name).css({"color": " #5bc0de", "font-weight": "bold", "font-size": "20px"});
                $("#address").html(data.address).css({"color": " #5bc0de", "font-weight": "bold", "font-size": "20px"});
                $("#email").html(data.email).css({"color": " #5bc0de", "font-weight": "bold", "font-size": "20px"});
                $("#gender").html(data.gender).css({"color": " #5bc0de", "font-weight": "bold", "font-size": "20px"});
                $("#contact_no").html(data.contact_no).css({"color": " #5bc0de", "font-weight": "bold", "font-size": "20px"});
                if (data.account.status) {
                    $("#status").html("Active");
                }
                $("#status").html(data.status).css({"color": "lime", "font-weight": "bold", "font-size": "20px"});
                

            });

            return false;
        });
    });

</script>


