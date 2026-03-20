window.addEventListener('DOMContentLoaded', () => {
    const tempoDeEspera = 1000;

    setTimeout(() => {
        // Aqui você poderá adicionar lógica de integração, por exemplo:
        // verificar se o usuário já está logado na API antes de redirecionar
        
        window.location.href = "../login/login.html";
    }, tempoDeEspera);
});