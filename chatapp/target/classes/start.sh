#!/bin/bash

# Ensure the script exits on error
set -e

# Navigate to the project root directory
cd "$(dirname "$0")/../../.."

# Compile the project
echo "Compiling the project..."
mvn clean package

echo

# Start MultiProcessCommunication (server) in the background
echo "Starting MultiProcessCommunication..."
java -cp target/classes com.chatapp.MultiProcessCommunication.MultiProcessCommunication &

# Wait a bit to ensure the server is up and running
sleep 3

echo

# Start SingleProcessCommunication (client) in the background
echo "Starting SingleProcessCommunication..."
java -cp target/classes com.chatapp.SingleProcessCommunication.SingleProcessCommunication &


# Wait a bit to let both processes start up
sleep 5

echo

echo "Both processes should now be running."
