import React from 'react';

const FormCliente = () => {
    return (
<form>

  <div class="field is-horizontal">
    <div class="field-label is-normal">
      <label class="label">Nombre Completo</label>
    </div>
    <div class="field-body">
      <div class="field">
        <p class="control is-expanded has-icons-left">
          <input
            autocomplete="off"
            class="input"
            type="text"
            placeholder="Nombre"
            name="nombres"
          />
          <span class="icon is-small is-left">
            <i class="fas fa-user"></i>
          </span>
        </p>
      </div>
      <div class="field">
        <p class="control is-expanded">
          <input
            autocomplete="off"
            class="input"
            type="text"
            placeholder="Apellidos"
            name="apellidos"
          />
        </p>
      </div>
    </div>
  </div>

  <div class="field is-horizontal">
    <div class="field-label is-normal">
      <label class="label">Direccion</label>
    </div>
    <div class="field-body">
      <div class="field">
        <div class="control is-expanded has-icons-left">
          <input
            autocomplete="off"
            class="input"
            type="text"
            placeholder="Ingrese su direccion"
            name="direccion"
          />
          <span class="icon is-small is-left">
            <i class="fas fa-map-marked-alt"></i>
          </span>
        </div>
      </div>
    </div>
  </div>

  <div class="field is-horizontal">
    <div class="field-label is-normal">
      <label class="label">Telefono</label>
    </div>
    <div class="field-body">
      <div class="field">
        <div class="control is-expanded has-icons-left">
          <input
            autocomplete="off"
            class="input"
            type="text"
            placeholder="Telefono"
            name="telefono"
          />
          <span class="icon is-small is-left">
            <i class="fas fa-phone"></i>
          </span>
        </div>
      </div>
    </div>
  </div>

  <div class="field is-horizontal">
    <div class="field-label is-normal">
      <label class="label">Email</label>
    </div>
    <div class="field-body">
      <div class="field">
        <div class="control is-expanded has-icons-left">
          <input
            autocomplete="off"
            class="input"
            type="email"
            placeholder="Ingrese su Email"
            name="email"
          />
          <span class="icon is-small is-left">
            <i class="fas fa-envelope"></i>
          </span>
        </div>
      </div>
    </div>
  </div>

  <div class="field is-horizontal">
    <div class="field-label"></div>
    <div class="field-body">
      <div class="field">
        <div class="control">
          <button type="submit" class="button is-primary mr-1">Guardar</button>
          <button type="button" class="button">Cancelar</button>
        </div>
      </div>
    </div>
  </div>

</form>

    );
}
 
export default FormCliente;