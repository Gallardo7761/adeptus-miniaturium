import PropTypes from 'prop-types';

const CustomContainer = ({ children }) => {
    return (
        <main className="mx-4 my-5">
            {children}
        </main>
    );
}

CustomContainer.propTypes = {
    children: PropTypes.node.isRequired,
}

export default CustomContainer;