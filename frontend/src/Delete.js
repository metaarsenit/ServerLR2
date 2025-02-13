import './App.css';

import React from "react";
import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';

const Delete = () => {
    const navigate = useNavigate(); 

    return (
        <div>
            <h1>Объект удален!</h1>
            <div>
                <button onClick={()=>{navigate("/")}}>Назад</button>
            </div>
            
        </div>
    );
}

export default Delete;