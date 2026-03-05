export function Form_login() {
    return (
        <section>
            <div>
                <h1>Olá, <br />Bem-vindo de volta!</h1>
                <form action="/login" method="POST">
                    <label htmlFor="email">Email:</label>
                    <input type="email" id="email" name="email" required />
                    <button type="submit">Entrar</button>
                    <input type="password" id="password" name="password" required />
                    <br /><br />
                    <button type="submit">Criar Conta</button>
                    <button type="submit">Login</button>
                </form>
            </div>
        </section>
    )
}