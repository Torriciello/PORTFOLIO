const form = document.getElementById('loginForm');

form.addEventListener('submit', async (event) => {
    event.preventDefault();

    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    try {
        const response = await fetch('http://localhost:8080/auth/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ email, password })
        });

        if (response.ok) {
            const data = await response.json();
            
            localStorage.setItem('token', data.token);
            
            window.location.href = "../index.html";

        } else if (response.status === 403 || response.status === 401) {
            alert('E-mail ou senha inválidos.');
        } else {
            alert('Erro no servidor. Tente novamente mais tarde.');
        }

    } catch (error) {
        console.error('Erro na conexão:', error);
        alert('Não foi possível conectar à API. Verifique se o container Docker está rodando.');
    }
});