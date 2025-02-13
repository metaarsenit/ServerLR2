import './App.css';

import React from "react";
import { useEffect, useState } from 'react';


const Test = () => {
    const [data, setData] = useState(null);

    useEffect(() => {
        fetch('http://localhost:8080/recipe')
            .then(response => response.json())
            .then(data => setData(data))
            .catch(error => console.error('Error:', error));
    }, []);

    return (
        <div>
            <h1>Data from Spring Boot:</h1>
            <table>
                <thead>
                    <th>Id</th>
                    <th>Название</th>
                </thead>
                <tbody>
                    { data ?
                        data.map((obj) =>{
                            return (
                                <tr>
                                    <td>{obj.id}</td>
                                    <td>{obj.name}</td>
                                </tr>
                            )
                        })
                        : "Loading"
                    }
                </tbody>
            </table>
        </div>
    );
}

export default Test;