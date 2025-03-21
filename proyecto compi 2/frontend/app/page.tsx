'use client';
import { Editor } from '@monaco-editor/react';
import { useState } from 'react';

const API_URL = 'http://localhost:5030';

export default function Home() {
  const [code, setCode] = useState<string>('');
  const [error, setError] = useState<string>('');
  const [output, setOutput] = useState<string>('');

  const handleExecute = async () => {
    try {
      const response = await fetch(`${API_URL}/compile`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ code }),
      });

      const data = await response.json();

      if (!response.ok) {
        throw new Error(data.error || 'Error desconocido');
      }

      setOutput(data.result);
      setError('');
    } catch (err) {
      setOutput('');
      setError(err instanceof Error ? err.message : 'Error desconocido');
    }
  };

  return (
    <div className='flex flex-col items-center justify-center min-h-screen p-4 bg-red-950 text-white'>
      <h1 className='text-3xl font-bold mb-4 text-white-400'>Consola</h1>
      <div className='grid grid-cols-1 md:grid-cols-2 gap-4 w-full max-w-6xl'>
        {/* Editor de Código */}
        <div className='bg-orange-900 p-4 rounded-lg shadow-lg'>
          <h2 className='text-lg font-semibold mb-2 text-black'>Editor</h2>
          <Editor
            height='60vh'
            defaultLanguage='javascript'
            theme='vs-dark'
            value={code}
            onChange={(value) => setCode(value || '')}
          />
          <button
            className='mt-4 w-full bg-yellow-600 hover:bg-yellow-700 text-black font-bold py-2 px-4 rounded'
            onClick={handleExecute}
          >
            Ejecutar
          </button>
        </div>

        {/* Resultados */}
        <div className='bg-orange-900 p-4 rounded-lg shadow-lg flex flex-col'>
          <h2 className='text-lg font-semibold mb-2 text-black'>Resultados</h2>
          <div className='flex-1 bg-red-950 p-2 rounded overflow-auto h-60'>
            {output && <pre className='text-white-300'>{output}</pre>}
            {error && <pre className='text-red-400'>{error}</pre>}
          </div>
        </div>
      </div>
    </div>
  );
}