<%@include file="../../header.jsp" %>
<h1 style="color:  #5bc0de;">WithDraw</h1>
<div class="form-group" >
    <div>
        <label class="col-md-1  control-label" for="email" >Enter name: </label>  
        <div class="col-md-4">
            <select name="cid" class="form-control" id="cid"> 
                <option value="">Select name</option>
                <c:forEach var="customers" items="${customers}">
                    <option value="${customers.id}">${customers.name}</option>
                </c:forEach>

            </select> 
        </div>
    </div>
    <div>
        <label class="col-md-1  control-label" for="accountno" >Enter account no: </label>  
        <div class="col-md-4">
            <select name="account_id" class="form-control" id="account_id"> 
                <option value="">Select Account No</option>
                <c:forEach var="accounts" items="${accounts}">
                    <option value="${accounts.id}">${accounts.account_no}</option>
                </c:forEach>

            </select> 

        </div>
        <button type="submit" id="btn-search" class="btn btn-success">Search</button>
        <button type="submit" id="btn-deposit" class="btn btn-warning">withdraw</button>
    </div>
</div>


<div>

    <table id="result" class="table table-bordered table-striped table-hover">
           </div>
<br><br><br><br>
           <div id="deposit-dialog" style="display: none">
           <form class="form-group"> 
            <label class="col-md-1 control-label" for="amount">Amount to withdraw:</label>
            <div class="col-md-4">
                <input type="text" id="amount" class="form-control"/> 
            </div>
            <button type="submit" id="btn-save" class="btn btn-warning">update</button>
        </form>
</div>


<script>
    $(document).on("ready", function () {
        var customer_id, account_id;
        $("#cid").on("change", function () {
            customer_id = $(this).val();
        });
        $("#account_id").on("change", function () {
            account_id = $(this).val();
        });
        $("#btn-search").on("click", function () {
            var $result = $("#result");
            //alert("customer_id" + customer_id + ", account_id" + account_id);
            $.get("**/api/balance/withdrawlist", {account_id: account_id, customer_id: customer_id}, function (data) {
                var content = "<tr><th>WithDrawn Date</th><th>Balance withdrawn</th></tr><tr>";
                $.each(data, function (i, o) {
                    content += "<td>" + o.withdrawn_date + " </td><td>" + o.amount + "</td></tr>";
                });
                content += "</table>";
                $result.html(content);

            }, 'json');

        });
        $("#btn-deposit").on("click", function () {
            $("#result").hide();
            $("#deposit-dialog").show();
        });
    
        $("#btn-save").on("click",function(){
                var amount=$("#amount").val();
           // alert("customer_id="+customer_id+",account_id="+account_id);
            $.get("/balance/save",{customer_id:customer_id,account_id:account_id,amount:amount},function(data){
             alert("hello");
            });
        });

    });

</script>