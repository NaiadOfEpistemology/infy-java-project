import { useState } from 'react'
import api from '../api'
import Input from '../components/Input'
import Button from '../components/Button'
import { useNavigate } from 'react-router-dom'

export default function Login() {
  const[email,setEmail]=useState('')
  const[password,setPassword]=useState('')
  const nav=useNavigate()

  const login=async()=>{
    const res=await api.post('/api/auth/login',{email,password})
    localStorage.setItem('token',res.data)
    nav('/dashboard')
  }

  return (
    <div style={{display:'flex',justifyContent:'center',alignItems:'center',height:'100vh',background:'#000022'}}>
      <div style={{width:'320px',padding:'24px',background:'#C42847',borderRadius:'12px'}}>
        <h2 style={{textAlign:'center'}}>Login</h2>
        <Input value={email} onChange={e=>setEmail(e.target.value)} placeholder="Email" type="text"/>
        <Input value={password} onChange={e=>setPassword(e.target.value)} placeholder="Password" type="password"/>
        <Button text="Login" onClick={login}/>
        <p onClick={()=>nav('/register')} style={{textAlign:'center',marginTop:'12px',cursor:'pointer'}}>Create account</p>
      </div>
    </div>
  )
}
