import './App.css';

import React from "react";
import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';

const Add = () => {
    const navigate = useNavigate(); 

    const [name, setName] = useState('');
    const [inputIngredient, setInputIngredient] = useState('');
    const [ingredients, setIngredients] = useState([]);

    const handleSubmit = async (e) => {
        e.preventDefault();

        const requestBody = {
            name: name,
            ingredients: ingredients
        };

        try {
            const response = await fetch('http://localhost:8080/recipe', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(requestBody)
            });

            if (!response.ok) {
                throw new Error(`Ошибка: ${response.statusText}`);
            }

            const data = await response.json();
            console.log('Рецепт добавлен:', data);

            // Очищаем форму после успешной отправки
            setName('');
            setIngredients([]);
            setInputIngredient('');

        }
        catch (error) {
            console.error("Ошибка при добавлении рецепта: ", error);
        }
    };

    const addIngredient = () => {
        if (inputIngredient.trim() !== '') {
            setIngredients([...ingredients, inputIngredient]);
            setInputIngredient('');
        }
    };

    return (
        <div>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>Название: </label>
                    <input type='text' value={name} onChange={(e)=> setName(e.target.value)} required></input>
                </div>

                <div>
                    <label>Ингредиенты:</label>
                    <input type='text' value={inputIngredient} onChange={(e)=> setInputIngredient(e.target.value)}></input>
                    <button type='button' onClick={addIngredient}>Добавить ингредиент</button>
                </div>


                <ul>
                    {ingredients ? ingredients.map((ing, index) => {
                        return (
                            <li key={index}>{ing}</li>
                        )
                    }) : "Добавьте ингредиенты..."}
                </ul>



                <button type='submit'>Создать</button>
            </form>
            
            <div>
                <button class="button" onClick={()=>{navigate("/")}}>Назад</button>
            </div>
            
        </div>
    );
}

export default Add;