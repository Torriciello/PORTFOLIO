async function logout() {
    const token = localStorage.getItem('token');

    try {
        await fetch('http://localhost:8080/logout', {
            method: 'POST',
            headers: {
                'Authorization': `Bearer ${token}`
            }
        });
    } catch (error) {
        console.error('Erro ao avisar o servidor sobre o logout:', error);
    } finally {
        localStorage.removeItem('token');
        window.location.href = "./login/login.html";
    }
}

document.addEventListener('DOMContentLoaded', () => {
    const token = localStorage.getItem('token');
    
    if (!token) {
        window.location.href = "./login/login.html";
    }
});