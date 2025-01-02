const loginBtn = document.querySelector('#loginBtn');
const logoutBtn = document.querySelector('#logoutBtn');
const loginForm = document.querySelector('.form-login');


const navBrand = document.querySelector('.navbar-brand');
const userIcon = document.querySelector('.user-icon');
const navHome = document.querySelector('.nav-link');

let path = window.location.pathname.split('/');

let indexPath = path;
indexPath[indexPath.length-1] = 'index.html';
indexPath = indexPath.join('/');

navBrand.href = indexPath;
navHome.href = indexPath;

loginBtn.addEventListener('click', e => {
    e.preventDefault();

    const user = {
        email: loginForm.email.value,
        password: loginForm.password.value
    };

    login(user);
});


async function login(user) {

    const response = await fetch('http://127.0.0.1:8080/test/login', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(user)
    });

    if (response.ok) {
        
        let utenteLogged = await response.json();

        let utente = {
            id: utenteLogged.utente_id,
            ruolo: utenteLogged.ruolo,
            nome: utenteLogged.nome
        }

        localStorage.setItem('currentUser', JSON.stringify(utente))

        path[path.length - 1] = 'utente.html';
        window.location.pathname = path.join('/');
    } else {
        alert('Invalid credentials!');
    }
}

// if utente email in localStorage -> form email value = localStorage(utenteEmail)

async function accessProtected() {
    const response = await fetch('http://127.0.0.1:8080/test/protected');
    const text = await response.text();
    alert(text);
}

async function logout() {
    await fetch('/test/logout', { method: 'POST' });

    localStorage.clear();

    path[path.length - 1] = 'login.html';
    window.location.pathname = path.join('/');
}


async function checkLoggato() {
    
    let utenteLoggato = localStorage.getItem('currentUser');

    if (utenteLoggato !== null) {
        return true;
    } else {
        return false;
    }
    
}

checkLoggato();