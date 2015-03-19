function updateEditAddress(empId, addId, rowId, myUrl) {
    $('#editEmpAddressForm').find('input[id=addressId]').val(addId);    //it will go to particular Action method
    $('#editEmpAddressForm').find('input[name=empId]').val(empId);
    
    var formId = $('#editEmpAddressForm').serialize();
               
    /*  var xmlhttp = new XMLHttpRequest();
                    xmlhttp.onreadystatechange = function() {
                        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                         document.getElementById(rowId).innerHTML = xmlhttp.responseText;
                        }
                    }
                    xmlhttp.open("GET", "updateAddress.do", true);
                    xmlhttp.send();
                */
    //   var myUrl = "<%=request.getContextPath()%>/showAddress.do?q=" + str;
    $.ajax({
        type: "POST",
        xhr:  getAjaxObject(),
        url: myUrl,
        async: true,
        data: formId,
        success: function(data){       // predefined method and arguments
           
            document.getElementById(rowId).innerHTML = data;
        },
        error: function(req,stat,err){      // predefined method and arguments
            alert('An Error has ocurred.Please try again');
        }
    }); 
}
            
function getAjaxObject(){
    (window.ActiveXObject) ?
    function() {
        try {
            return new window.ActiveXObject("Microsoft.XMLHTTP");
        } catch(e) {}
    } :
    function() {
        return new window.XMLHttpRequest();
    }
}
function updateAddress(empId, addId, myUrl) {
    //$('#updateAddressForm').find('input[id=addressId]').val(addId);    //it will go to particular Action method
    $('#updateAddressForm').find('input[name=empId]').val(empId);
    
    var formId = $('#updateAddressForm').serialize();
    
    $.ajax({
        type: "POST",
        xhr:  getAjaxObject(),
        url: myUrl,
        async: true,
        data: formId,
        success: function(returndata){       // predefined method and arguments
           
            document.getElementById('showAddress').innerHTML = returndata;
        },
        error: function(req,stat,err){      // predefined method and arguments
            alert('An Error has ocurred. while updating address.');
        }
    });
}
function getAjaxObject(){
    (window.ActiveXObject) ?
    function() {
        try {
            return new window.ActiveXObject("Microsoft.XMLHTTP");
        } catch(e) {}
    } :
    function() {
        return new window.XMLHttpRequest();
    }
}

function deActivateEmpAll(deActivateUrl, path) {
    //$('#updateAddressForm').find('input[id=addressId]').val(addId);    //it will go to particular Action method
    //$('#deActivateForm').find('input[name=empId]').val(empId);
    var formId = $('#deActivateForm').serialize();
    
    $.ajax({
        type: "POST",
        xhr:  getAjaxObject(),
        url: deActivateUrl,
        async: true,
        data: formId,
        success: function(returndata){       // predefined method and arguments
           window.location.replace(path);
        },
        error: function(req,stat,err){      // predefined method and arguments
            alert('An Error has ocurred. while DeActivating Employee.');
        }
    });
}
function getAjaxObject(){
    (window.ActiveXObject) ?
    function() {
        try {
            return new window.ActiveXObject("Microsoft.XMLHTTP");
        } catch(e) {}
    } :
    function() {
        return new window.XMLHttpRequest();
    }
}

function color(){
    var colorChange = document.getElementbyId('red');
    colorChange.style.color = "red"; 
}

function color_green(){
    var colorChange = document.getElementbyId('green');
    colorChange.style.color = "green"; 
}