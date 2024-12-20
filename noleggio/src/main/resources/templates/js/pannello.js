const USERS = [
    { userid: "admin", password: "admin123", role: "ADMIN" },
    { userid: "user", password: "user123", role: "USER" }
];

//LOGIN!!
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
        window.location.href="errore.html";
        document.getElementById("login-section").style.display = "none";
        document.getElementById("error-section").style.display = "block";
    }

}


// LOGOUT!!!
function logout() {
    window.location.href = "index.html"; 
}

//INSERIMENTO NUOVO VEICOLO
function submitForm(e) {
    e.preventDefault();
    const formData = {
        category: document.getElementById("category").value,
        anno:document.getElementById("anno").value,
        marca:document.getElementById("marca").value,
        modello:document.getElementById("modello").value,
        colore:document.getElementById("colore").value,
        cilindrata:document.getElementById("cilindrata").value,
        fuel: document.getElementById("fuel").value,
        address: document.getElementById("address").value,
        gps: document.getElementById("gps").value,
        availability: document.getElementById("availability").value
    }
    
    fetch('/api/veicolo', {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(formData)
    })
    .then (response => {
        console.log(response);
        return response.json();
    })
};
