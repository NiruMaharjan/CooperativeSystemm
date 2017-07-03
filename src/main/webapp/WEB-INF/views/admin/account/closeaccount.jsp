
<%@include file="../../header.jsp" %>
<div>

    <div class="col-md-4">
        <select id="cid" class="form-control">
            <option value="">Select name</option>
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



                <label class="col-md-1  control-label" for="name" >Identification No: </label>  
                <div class="col-md-4">
                    <div id="id_no"></div>
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
                <label class="col-md-1  control-label" for="status" >Status</label>  
                <div class="col-md-4">
                    <div id="status"></div>
                    <span class="help-block"> </span>  
                </div>
            </div>
        </fieldset>
        <br/>

        <fieldset>
            <legend>Account Closure </legend>
            <div class="form-group">
                <label class="col-md-1 control-label" for="accountclosuredate">Account Closure Date:</label>  
                <div class="col-md-4">
                    <div id="account_closure_date"></div>
                    <span class="help-block"> </span>  
                </div>
                <label class="col-md-1 control-label" for="balance">Current Account Balance:</label>  
                <div class="col-md-4">
                    <div id="balance"></div>
                </div>
                <br/><br/><br/><br/>



                <label class="col-md-1  control-label" for="name" >Closure Reason: </label>  
                <div class="col-md-4">
                    <textarea  id="closure_reason" class="form-control"></textarea>
                    <span class="help-block"> </span>  
                </div>
                <br>
                <input type="hidden" id="customer_id"/><br>
                <input type="hidden" id="account_id"/>

            </div>

            <br/>
            <br/>
            <button type="submit" class="btn btn-warning" id="close_account">Close Account </button>



        </fieldset>


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
            var date = new Date();
            var closuredate = date.toISOString();
            //alert(date);
            //alert(cname);
            $.getJSON("**/api/detaillist", {cid: cid}, function (data) {
                //alert(data.name+" "+data.address);
                $("#account_number").html(data.customer.account.account_no).css({"color": " #5bc0de", "font-weight": "bold", "font-size": "20px"});

                $("#account_type").html(data.customer.account.account_type).css({"color": " #5bc0de", "font-weight": "bold", "font-size": "20px"});
                $("#id_no").html(data.customer.account.identification_id_no).css({"color": " #5bc0de", "font-weight": "bold", "font-size": "20px"});
                $("#name").html(data.customer.name).css({"color": " #5bc0de", "font-weight": "bold", "font-size": "20px"});
                $("#address").html(data.customer.address).css({"color": " #5bc0de", "font-weight": "bold", "font-size": "20px"});
                $("#email").html(data.customer.email).css({"color": " #5bc0de", "font-weight": "bold", "font-size": "20px"});
                $("#gender").html(data.customer.gender).css({"color": " #5bc0de", "font-weight": "bold", "font-size": "20px"});
                $("#contact_no").html(data.customer.contact_no).css({"color": " #5bc0de", "font-weight": "bold", "font-size": "20px"});
                $("#status").html(data.customer.account.status).css({"color": "lime", "font-weight": "bold", "font-size": "20px"});
                $("#account_id").val(data.customer.account.id);
                $("#customer_id").val(data.customer.id);
                $("#balance").html(data.amount);
                if (data.customer.account.status == true) {
                    $("#status").html("Active");
                }
                $("#account_closure_date").html(closuredate);




            });

            return false;
        });
        $("#close_account").on("click", function () {
            var account_closure_date = $("#account_closure_date").html();
            var closure_reason = $("#closure_reason").val();
            var account_id = $("#account_id").val();
            var customer_id = $("#customer_id").val();
            $.get("**/api/closeaccount/save", {account_closure_date: account_closure_date, closure_reason: closure_reason, account_id: account_id, customer_id: customer_id}, function (data) {
                alert(data);
            });
            return false;


        });
    });

</script>


