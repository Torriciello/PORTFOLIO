import { Back_button } from "../Back_button/Back_button";
import { Continue_button } from "../Continue_button/Continue_button";
import { Seleciona_catador } from "../Seleciona_catador";
import { Seleciona_contribuinte } from "../Seleciona_Contribuinte";
import "./form_register.estilos.css";

export function Form_register() {
    return (
        <section>
            <div>
                <img src="register.png" alt="" />
                <Seleciona_catador/>
                <Seleciona_contribuinte/>
                <Continue_button/>
                <Back_button/>
            </div>
        </section>
        
    );
}