const loginBtn = document.querySelector('#loginBtn');
const loginForm = document.querySelector('.form-login');

loginBtn.addEventListener('click', e => {
    e.preventDefault();

    const user = {
        email: loginForm.email.value,
        password: loginForm.password.value
    };

    login(user);
});


async function login(user) {

    const response = await fetch('localhost:8080/test/login', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(user)
    });

    if (response.ok) {
        // salva in localStorage utente email?
        alert('Login successful!');
    } else {
        alert('Invalid credentials!');
    }
}

// if utente email in localStorage -> form email value = localStorage(utenteEmail)

async function accessProtected() {
    const response = await fetch('localhost:8080/test/protected');
    const text = await response.text();
    alert(text);
}

async function logout() {
    await fetch('/test/logout', { method: 'POST' });
    alert('Logged out!');
}

const uriUtente = 'api/utente/curr';

let currUtente;
let isLoggato = false;

async function checkLoggato() {
    await fetch (uriUtente) 
        .then(response => response.json())
        .then(data => {
            currUtente = data;
        })
        .catch (err => console.log(err));
    
}

checkLoggato();