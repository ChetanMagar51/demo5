// common.js

// Function to display modal
function showModal(modalId) {
    document.getElementById(modalId).style.display = "block";
}

// Function to close modal
function closeModal(modalId) {
    document.getElementById(modalId).style.display = "none";
}

// Function to confirm deletion
function confirmDelete(itemId, itemType) {
    return confirm(`Are you sure you want to delete this ${itemType} with ID ${itemId}?`);
}

// Common function for AJAX request handling
function ajaxRequest(url, method, data, callback) {
    const xhr = new XMLHttpRequest();
    xhr.open(method, url, true);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            callback(JSON.parse(xhr.responseText));
        }
    };
    xhr.send(JSON.stringify(data));
}
