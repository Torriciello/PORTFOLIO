import './form-login.estilo.css'
import { Button_login } from '../button_login'
import { Button_register } from '../button_register'

export function Form_login(){
  return(

    <section className="form-area">

      <h1>
        Olá,<br/>
        Bem-vindo de volta!
      </h1>

      <form className="form">

        <input
          type="email"
          placeholder="Digite o seu e-mail"
        />

        <input
          type="password"
          placeholder="Senha"
        />

        <div className="options">

          <label>
            <input type="checkbox"/>
            Mostrar a minha senha
          </label>

          <a href="#">Esqueci a minha senha</a>

        </div>

        <div className="buttons">

          <Button_register>
            Criar conta
          </Button_register>

          <Button_login>
            Login
          </Button_login>

        </div>

      </form>

    </section>

  )
}