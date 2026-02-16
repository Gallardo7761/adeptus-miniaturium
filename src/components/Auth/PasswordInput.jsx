import { useState } from 'react';
import { Form, FloatingLabel, Button } from 'react-bootstrap';
import '@/css/PasswordInput.css';

import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faEye, faEyeSlash, faKey } from '@fortawesome/free-solid-svg-icons';
import { useTranslation } from 'react-i18next';

const PasswordInput = ({ value, onChange, name = "password" }) => {
  const [show, setShow] = useState(false);
  const { t } = useTranslation();

  const toggleShow = () => setShow(prev => !prev);

  return (
    <div className="position-relative w-100">
      <FloatingLabel
        controlId="passwordInput"
        label={
          t("login.password_label")
        }
      >
        <Form.Control
          type={show ? "text" : "password"}
          name={name}
          value={value}
          placeholder=""
          onChange={onChange}
          className="rounded-0 pe-5"
        />
      </FloatingLabel>

      <Button
        variant="link"
        className="show-button position-absolute end-0 top-50 translate-middle-y me-2"
        onClick={toggleShow}
        aria-label="Mostrar contraseña"
        tabIndex={-1}
        style={{ zIndex: 2 }}
      >
        <FontAwesomeIcon icon={show ? faEyeSlash : faEye} className='fa-lg' />
      </Button>
    </div>
  );
};

export default PasswordInput;
