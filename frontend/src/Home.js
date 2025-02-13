
import React from "react";
import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';

const Home = () => {
    const navigate = useNavigate(); 

    return (
        <div>
            <h1>Главная страница</h1>
            <div>
                <button onClick={()=>{navigate("/view")}}>Просмотреть</button>
            </div>
            <div>
                <button onClick={()=>{navigate("/add")}}>Добавить</button>
            </div>
            
        </div>
    );
}

export default Home;