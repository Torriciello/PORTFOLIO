import { Form_login } from "../../components/Form_login";
import "./login.estilo.css";

export default function Login() {
  return (
    <main className="container">
      <div className="left">
        <img src="/logo.svg" className="logo" />

        <Form_login />
      </div>

      <div className="right">
        <img src="/reciclagem.png" className="image" />
      </div>
    </main>
  );
}

