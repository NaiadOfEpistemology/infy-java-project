import { useState } from 'react'
import api from '../api'
import Input from '../components/Input'
import Button from '../components/Button'
import { useNavigate } from 'react-router-dom'

export default function Register() {
  const[email,setEmail]=useState('')
  const[password,setPassword]=useState('')
  const[name,setName]=useState('')
  const nav=useNavigate()

  const register=async()=>{
    await api.post('/api/auth/register',{
      email,
      password,
      fullName:name
    })
    nav('/')
  }

  return (
    <div style={{display:'flex',justifyContent:'center',alignItems:'center',height:'100vh',background:'#000022'}}>
      <div style={{width:'320px',padding:'24px',background:'#DE3C4B',borderRadius:'12px'}}>
        <h2 style={{textAlign:'center'}}>Register</h2>
        <Input value={name} onChange={e=>setName(e.target.value)} placeholder="Full Name" type="text"/>
        <Input value={email} onChange={e=>setEmail(e.target.value)} placeholder="Email" type="text"/>
        <Input value={password} onChange={e=>setPassword(e.target.value)} placeholder="Password" type="password"/>
        <Button text="Sign Up" onClick={register}/>
        <p onClick={()=>nav('/')} style={{textAlign:'center',marginTop:'12px',cursor:'pointer'}}>Back to login</p>
      </div>
    </div>
  )
}
