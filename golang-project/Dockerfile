# Stage 1: Build the Go binary
FROM golang:1.22-alpine AS builder

WORKDIR /app

# Copy the Go modules manifests
COPY go.mod ./

# Copy the source code
COPY main.go ./

# Build the application as a statically linked binary (CGO_ENABLED=0)
# This allows it to run in an empty 'scratch' image
RUN CGO_ENABLED=0 GOOS=linux go build -o server .

# Stage 2: Create the minimal runtime image
FROM scratch

# Copy the compiled binary from the builder stage
COPY --from=builder /app/server /server

# Expose port
EXPOSE 8080

# Run the binary
CMD ["/server"]
