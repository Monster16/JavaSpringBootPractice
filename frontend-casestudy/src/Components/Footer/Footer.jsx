import React from 'react';
import './Footer.css';

const Footer = () => {
    return (
        <footer className="footer-container">
            <p>
                &copy; {new Date().getFullYear()} Copyright: By Anil Singh
            </p>
        </footer>
    );
};

export default Footer;