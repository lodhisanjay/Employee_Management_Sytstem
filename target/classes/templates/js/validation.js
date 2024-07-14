// Form validation function
document.getElementById("addEmpForm").addEventListener("submit", function(event) {
    var nameInput = document.getElementById("name");
    var phnoInput = document.getElementById("phno");

    // Check for special characters in name
    var nameRegex = /^[a-zA-Z\s]*$/;
    if (!nameRegex.test(nameInput.value)) {
        alert("Name should only contain alphabets and spaces.");
        event.preventDefault();
        return false;
    }

    // Check if phone number is greater than 10 digits
    if (phnoInput.value.length > 10) {
        alert("Phone number should not exceed 10 digits.");
        event.preventDefault();
        return false;
    }
});
