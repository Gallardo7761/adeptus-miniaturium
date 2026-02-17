import PropTypes from 'prop-types';

const CustomContainer = ({ children }) => {
    return (
        <main className="container my-5">
            <div className="d-flex flex-column gap-5">
                {children}
            </div>
        </main>
    );
}

CustomContainer.propTypes = {
    children: PropTypes.node.isRequired,
}

export default CustomContainer;