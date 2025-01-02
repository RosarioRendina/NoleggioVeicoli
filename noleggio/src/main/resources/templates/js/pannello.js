let path = window.location.pathname.split('/');

if (path[path.length - 1] !== 'errore.html') {
    let currentUser = JSON.parse(localStorage.getItem('currentUser'));
    
    if (currentUser === null) {
        sessionStorage.setItem('redirect', path[path.length - 1]);
        path[path.length - 1] = 'login.html';
        window.location.href = path.join('/');
    } else if (currentUser.ruolo === 'UTENTE') {
        path[path.length - 1] = 'errore.html';
        window.location.href = path.join('/');
    }
    
    const welcome = document.querySelector('h2.welcome');
    const logoutBtn = document.querySelector('#logoutBtn');
    const inserisciBtn = document.querySelector('#inserisciBtn');
    
    welcome.innerText = `Benvenuto, ${currentUser.nome}!`;
    
    inserisciBtn.addEventListener('click', e => {
        e.preventDefault();
        
        path[path.length - 1] = 'inserisci.html';
        window.location.href = path.join('/');
    });
}

logoutBtn.addEventListener('click', e => {
    e.preventDefault();

    localStorage.clear();
    if (path[path.length - 1] === 'errore.html') {
        sessionStorage.setItem('redirect', 'pannello.html');
        path[path.length - 1] = 'login.html';
    } else {
        path[path.length - 1] = 'index.html';
    }
    window.location.href = path.join('/');
})

/* ----------------------------- inserisci html ----------------------------- */
function submitForm(e) {
    e.preventDefault();
    const formData = {
        category: document.getElementById("category").value,
        anno: document.getElementById("anno").value,
        marca: document.getElementById("marca").value,
        modello: document.getElementById("modello").value,
        colore: document.getElementById("colore").value,
        cilindrata: document.getElementById("cilindrata").value,
        fuel: document.getElementById("fuel").value,
        address: document.getElementById("address").value,
        gps: document.getElementById("gps").value,
        availability: document.getElementById("availability").value
    };

    fetch('/api/veicolo', {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(formData)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error(`Errore HTTP: ${response.status}`);
        }
        return response.json();
    })
    .then(data => {
        console.log("Risposta ricevuta dal server:", data);
       
        alert("Veicolo postato correttamente!");
    })
    .catch(error => {
        console.error("Si è verificato un errore:", error);
        alert("Errore durante l'invio dei dati.");
    });
}

