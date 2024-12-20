const USERS = [
    { userid: "admin", password: "admin123", role: "ADMIN" },
    { userid: "user", password: "user123", role: "USER" }
];

function login() {
    const userid = document.getElementById("userid").value;
    const password = document.getElementById("password").value;

    const user = USERS.find(u => u.userid === userid && u.password === password);

    // if (!user) {
    //     alert("Credenziali errate!");
    //     return;
    // }

    if (user.role === "ADMIN") {
        document.getElementById("login-section").style.display = "none";
        document.getElementById("admin-section").style.display = "block";
    } else if (user.role === "USER") {
        window.location.href="errore.html"
        document.getElementById("login-section").style.display = "none";
        document.getElementById("error-section").style.display = "block";
    }

}