<%@include file="../../header.jsp" %>
<h1 style="color:  #5bc0de;">Deposit</h1>
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
        <button type="submit" id="btn-deposit" class="btn btn-warning">Deposit</button>

    </div>
</div>


<div>

    <table id="result" class="table table-bordered table-striped table-hover">
</div>
<div id="displaytotal" style="display: none">
    Total:  <h1 id="total">  <h1/>
        Interest:<h1 id="interest"></h1>
</div>
<br><br><br><br>
<div id="deposit-dialog" style="display: none">
    <form class="form-group"> 
        <label class="col-md-1 control-label" for="amount">Enter amount to deposit:</label>
        <div class="col-md-4">
            <input type="text" id="amount" class="form-control"/> 
        </div>
        <button type="submit" id="btn-save" class="btn btn-warning">Save</button>
    </form>
</div>


<script>
    $(document).on("ready", function () {
        var customer_id, account_id, total = 0, interest = 0;
        var arr = [];
        $("#cid").on("change", function () {
            customer_id = $(this).val();
        });
        $("#account_id").on("change", function () {
            account_id = $(this).val();
        });
        $("#btn-search").on("click", function () {
            var $result = $("#result");
            //alert("customer_id" + customer_id + ", account_id" + account_id);
            $.get("**/api/balance/amountlist", {account_id: account_id, customer_id: customer_id}, function (data) {

                var content = "<tr><th>Deposited Date</th><th>Balance</th></tr><tr>";
                $.each(data, function (i, o) {
                    arr.push(o.added_Date);
                    content += "<td>" + o.added_Date + " </td><td>" + o.amount + "</td></tr>";
                    total += o.amount;
                });
                content += "</table>";
                $result.html(content);
                var display = $("#displaytotal");
                $("#total").html(total);
                $result.append(display);
                display.show();
                var i;
                var firstDepositedDate, lastDepositedDate;
                for (i = 0; i < arr.length; i++) {
                    firstDepositedDate = arr[i - i];
                    lastDepositedDate = arr[i];
                }
                //alert(lastDepositedDate + " " + firstDepositedDate);
                // alert(arr);
                var lastDepositedDate = new Date(lastDepositedDate);
                firstDepositedDate = new Date(firstDepositedDate);
                //alert("month"+plusdate.getMonth());
//                var addmonthindate = lastDepositedDate.setMonth(lastDepositedDate.getMonth() + 1);
//                var dateafteraddingamonth= new Date(addmonthindate);
//                alert(firstDepositedDate+dateafteraddingamonth);
                //alert("addmonthindate"+addmonthindate);
                // var a = plusdate.setMonth(plusdate.getMonth() + 1);
                //var b=datetobedisplayed.toISOString();
//                var difference=Math.abs(dateafteraddingamonth.getTime()-firstDepositedDate.getTime());
//                var diffDays=Math.ceil(difference/(1000*3600*24));
                //var diffDays=Math.round(Math.abs((dateafteraddingamonth.getTime()-firstDepositedDate.getTime())/(24*60*60*1000)));
                // alert("last" + lastDepositedDate + "first" + firstDepositedDate);
                var msDay = 60 * 60 * 24 * 1000;
                //var diffDays = Math.floor((lastDepositedDate - firstDepositedDate) / msDay);
                var difference = Math.abs(lastDepositedDate.getTime() - firstDepositedDate.getTime());
                var diffDays = Math.ceil(difference / (1000 * 3600 * 24));
                // alert("difference" + diffDays);

                var afteronemonth = firstDepositedDate.addDays(30);
                // alert("afteronemoth="+afteronemonth);

                var differencedates = Math.abs(afteronemonth.getTime() - firstDepositedDate.getTime());
                var diffDayss = Math.ceil(differencedates / (1000 * 3600 * 24));
                // alert("differencedatess" + diffDayss);
                var currentdate = new Date();
                // alert("currentdate"+currentdate);
                var subtract = Math.abs(currentdate.getTime() - firstDepositedDate.getTime());
                var differencebetweencurrentdateandfirstDepositedDate = Math.ceil(subtract / (1000 * 3600 * 24));
                // alert(differencebetweencurrentdateandfirstDepositedDate);

                var count = 0;

                if (differencebetweencurrentdateandfirstDepositedDate >=  31) {
                    interest = interest + (9 / 1200 * total); //to make it monthtly interest divide it by 1200(12*100)


                }
                else {
                    interest = 0;
                }
                $("#interest").html(interest);
                //alert(difference);






            }, 'json');
        });
        $("#check").on("click", function () {


            var c = $("#result").find("tr").last();
            alert(c.amount);
            return false;
        });
        $("#btn-deposit").on("click", function () {
            $("#result").hide();
            $("#deposit-dialog").show();
        });
        $("#btn-save").on("click", function () {
            var amount = $("#amount").val();
            //alert("customer_id=" + customer_id + ",   amount=" + amount);
            $.get("**/api/balance/save", {customer_id: customer_id, account_id: account_id, amount: amount}, function (data) {
                alert("Saved");
                $("#amount").val(" ");
            });
            return false;
        });
    });
    Date.prototype.addDays = function (days) {
        var dat = new Date(this.valueOf());
        dat.setDate(dat.getDate() + days);
        return dat;
    }

</script>