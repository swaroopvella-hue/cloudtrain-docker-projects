const express = require('express');

const app = express();
const PORT = process.env.PORT || 8080;

app.get('/', (req, res) => {
    res.json({
        message: 'Hello from Node.js Project!',
        techStack: 'Node.js',
        status: 'Success'
    });
});

app.listen(PORT, '0.0.0.0', () => {
    console.log(`Node.js app is running on http://0.0.0.0:${PORT}`);
});
