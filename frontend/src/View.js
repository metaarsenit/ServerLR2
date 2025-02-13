
import React from "react";
import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';

const View = () => {
    const navigate = useNavigate(); 

    const [data, setData] = useState(null);
    
    useEffect(() => {
        fetch('http://localhost:8080/recipe')
            .then(response => response.json())
            .then(data => setData(data))
            .catch(error => console.error('Error:', error));
    }, []);

    const deleteRecipe = async (id) => {
        try {
            console.log(id);
            const response = await fetch('http://localhost:8080/recipe/' + id, {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json'
                }
            });
    
            if (!response.ok) {
                throw new Error(`Ошибка: ${response.statusText}`);
            }
    
            console.log(`Item ${id} deleted successfully`);
            navigate("/delete")
        } catch (error) {
            console.error('Ошибка при удалении:', error);
        }
    }

    return (
        <div className="main">
            <h1>Просмотреть</h1>
                
            { data ? data.map((obj) => {
                return (
                    <div>
                        <h3>{obj.id}. {obj.name}</h3>
                        <button onClick={()=>deleteRecipe(obj.id)}>Удалить</button>
                        <h5>Ингредиенты:</h5>
                        {obj.ingredients ? obj.ingredients.map((ing) => {
                            return (
                                <p>{ing}</p>
                            )
                        }) : "Нет ингредиентов"}
                    </div>
                )
            }) : "Loading..."}
                

            <div>
                <button onClick={()=>{navigate("/")}}>Назад</button>
            </div>
            
        </div>
    );
}

export default View;