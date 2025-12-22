import { OBTENER_CLIENTE, OBTENER_CLIENTES, REGISTRAR_CLIENTE } from "../components/const/actionTypes";

export default (state, action) => {

    switch (action.type) {
        case OBTENER_CLIENTES:
            
            return {
                ...state,
                clientesList: action.payload
            };
        
        case REGISTRAR_CLIENTE:
            return {
                ...state,
                clientesList: [...state.clientesList, action.payload]
            }
        case OBTENER_CLIENTE:
            return {
                ...state,
                clienteActual: action.payload
            };
        default:
            return state;
    }
}