async function login() {
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    const response = await fetch('localhost:8080/test/login', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ email, password })
    });

    if (response.ok) {
        // salva in localStorage utente email
        alert('Login successful!');
    } else {
        alert('Invalid credentials!');
    }
}

// if utente email in localStorage -> form email value = localStorage(utenteEmail)

async function accessProtected() {
    const response = await fetch('/test/protected');
    const text = await response.text();
    alert(text);
}

async function logout() {
    await fetch('/test/logout', { method: 'POST' });
    alert('Logged out!');
}

