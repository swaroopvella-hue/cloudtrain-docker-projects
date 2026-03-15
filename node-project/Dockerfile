# Use the official Node.js Alpine image for a smaller footprint Question
FROM node:20-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy package.json and package-lock.json first to leverage Docker cache
COPY package.json ./

# Install project dependencies
RUN npm install

# Copy the rest of the application source code
COPY . .

# Expose port 8080 to the host Question
EXPOSE 8080

# Command to run the application - ["npm", "start"] Question
CMD ["npm", "start"]
