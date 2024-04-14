import {useEffect,useState} from 'react'

export function UseHook(endpoint) {

    const [data, setData] = useState(null);
    
    
    useEffect(()=>{
        fetch(endpoint)
        .then((response) => response.json())
        .then((data) => setData(data))
        .catch((error) => alert(error))

    },[]);


    return {data}
}

 