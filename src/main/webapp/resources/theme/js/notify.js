$(document).ready(function ()
{
    function validateForm() {
        var u = document.getElementById("username").value;
        var p = document.getElementById("password").value;
        if (u == "") {
            alert("Please enter your Username");
            return false;
        }
        if (p == "") {
            alert("Please enter you Password");
            return false;
        }

        alert("All datas are valid!, send it to the server!")

        return true;
    }
});