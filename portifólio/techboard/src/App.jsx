import './App.css'
import {Tema} from './componentes/Tema'
import { FormularioDeEvento } from './componentes/FormularioDeEvento'
import { Banner } from './componentes/Banner'
// no react, componentes são FUNÇÕES

function App() {

  const temas = [
    {
      id: 1,
      nome: 'front-end'
    }, 
    {
      id: 2,
      nome: 'backend'
    },
    {
      id: 3, 
      nome: 'Devops'
    },
    {
      id: 4, 
      nome: 'Inteligencia Artificial'
    },
    {
      id: 5, 
      nome: 'Data Science'
    }
    ,
    {
      id: 6, 
      nome: 'Clound'
    }
  ]

  return (
    <main>
      <header>
        <img src="/logo.png" alt="" />
      </header>
      <Banner />
      <FormularioDeEvento />
      <section>
        <Tema tema={temas[0]}/>
      </section>
      <section>
        <Tema tema={temas[1]}/>
      </section>
      <section>
        <Tema tema={temas[2]}/>
      </section>
      <section>
        <Tema tema={temas[3]}/>
      </section>
      <section>
        <Tema tema={temas[4]}/>
      </section>
      <section>
        <Tema tema={temas[5]}/>
      </section>
    </main>
  )
}

export default App
