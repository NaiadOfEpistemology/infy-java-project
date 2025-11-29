export default function Input({value,onChange,type,placeholder}) {
    return (
      <input
        value={value}
        onChange={onChange}
        type={type}
        placeholder={placeholder}
        style={{
          width: '100%',
          padding: '12px',
          marginBottom: '12px',
          borderRadius: '6px',
          border: 'none',
          background: 'rgba(255,255,255,0.2)',
          color: '#FFFFFF'
        }}
      />
    )
  }
  