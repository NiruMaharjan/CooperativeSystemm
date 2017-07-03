
<%@include file="../../header.jsp" %>
<div>

    <form   method="post" action="${SITE_URL}/account/save" id="customer-form">


        <fieldset>
            <legend style="color:  #5bc0de;">Account Information</legend>
            <div class="form-group">
                <label class="col-md-1 control-label" for="name">Account Number:</label>  
                <div class="col-md-4">
                    <input id="account_number" name="account_number" placeholder="Enter account number" class="form-control input-md" required=""  type="text">
                    <span class="help-block"> </span>  
                </div>
                <label class="col-md-1 control-label" for="name">Account type:</label>  
                <div class="col-md-4">
                    <select id="account_type" name="account_type" class="form-control" >
                        <a href="openaccount.jsp">
                            <option value="">choose account type</option>
                            <option value="current">Current</option>
                            <option value="saving">Fixed</option>
                    </select>
                </div>
                <br/><br/><br/><br/>



                <label class="col-md-1  control-label" for="name" >Identification </label>  
                <div class="col-md-4">
                    <input id="id_no" name="id_no" placeholder="Identification number" class="form-control input-md" required=""  type="text">
                    <span class="help-block"> </span>  
                </div>
            </div>



        </fieldset>
        <br/><br/>
        <fieldset>
            <legend style="color:  #5bc0de; ">Personal Information</legend>
            <div class="form-group">
                <label class="col-md-1 control-label" for="name">Name:</label>  
                <div class="col-md-4">
                    <input id="name" name="name" placeholder="Enter name" class="form-control input-md" required=""  type="text">
                    <span class="help-block"> </span>  
                </div>
                <label class="col-md-1 control-label" for="address">Address:</label>  
                <div class="col-md-4">
                    <input id="address" name="address" placeholder="Enter Address"  class="form-control input-md" required=""  type="text">
                    <span class="help-block"> </span>  
                </div>
                <br/><br/><br/>



                <label class="col-md-1  control-label" for="email" >Email: </label>  
                <div class="col-md-4">
                    <input id="email" name="email" placeholder="Enter email" class="form-control input-md" required=""  type="text">
                    <span class="help-block"> </span>  
                </div>

                <label class="col-md-1  control-label" for="name" >Gender :</label>  
                <div class="col-md-4">
                    <select id="gender" name="gender" class="form-control" >
                        <option value="">Gender</option>
                        <option value="male">Male</option>
                        <option value="female">Female</option>
                        <option value="other">Other</option>
                    </select>
                </div>
                <br/><br/><br/>

                <label class="col-md-1  control-label" for="contact_no" >Contact_no:</label>  
                <div class="col-md-4">
                    <input id="contact_no" name="contact_no" placeholder="Enter contact number" class="form-control input-md" required=""  type="text">
                    <span class="help-block"> </span>  
                </div>
                <br/><br/><br/><br/>
                <label class="col-md-1  control-label" for="status" >Status</label>  
                <div class="col-md-4">
                    <input id="status" name="status"   required=""  type="checkbox">
                    <span class="help-block"> </span>  
                </div>
            </div>
        </fieldset>
        <br/>

        <button type="submit" id="save" class="btn btn-success">Save</button>
        <button type="reset" class="btn btn-warning">Reset</button>

    </form>
</div>
    <script>
        $(document).on("ready",function(){
           alert(hello) ;
        });
        </script>
    

