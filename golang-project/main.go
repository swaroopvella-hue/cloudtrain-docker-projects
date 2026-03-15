package main

import (
    "encoding/json"
    "fmt"
    "log"
    "net/http"
    "os"
)

type Response struct {
    Message   string `json:"message"`
    TechStack string `json:"techStack"`
    Status    string `json:"status"`
}

func handler(w http.ResponseWriter, r *http.Request) {
    w.Header().Set("Content-Type", "application/json")
    response := Response{
        Message:   "Hello from Golang Project!",
        TechStack: "Go (net/http)",
        Status:    "Success",
    }
    json.NewEncoder(w).Encode(response)
}

func main() {
    port := os.Getenv("PORT")
    if port == "" {
        port = "8080"
    }

    http.HandleFunc("/", handler)
    fmt.Printf("Golang server starting on port %s...\n", port)
    log.Fatal(http.ListenAndServe(":"+port, nil))
}
