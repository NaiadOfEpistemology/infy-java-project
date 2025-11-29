export default function Button({text,onClick}) {
    return (
      <button
        onClick={onClick}
        style={{
          width: '100%',
          padding: '12px',
          borderRadius: '6px',
          border: 'none',
          background: '#E28413',
          color: '#FFFFFF',
          fontWeight: 'bold',
          cursor: 'pointer'
        }}
      >
        {text}
      </button>
    )
  }
  