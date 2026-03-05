import './button_login.estilo.css'

export function Button_login({children}){
    return(
        <button className="btn-login">
            {children}
        </button>
    )
}