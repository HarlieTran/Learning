$(document).ready(function () {
    // Function to load JSON data
    async function loadData(jsonFile) {
        try {
            const response = await fetch(jsonFile);
            if (!response.ok) throw new Error('Failed to load data');
            const data = await response.json();
            return data.weather;
        } catch (error) {
            console.error(error);
            return [];
        }
    }

    // Generate Pie Chart
    function generatePieChart(containerId, labels, data) {
        const container = $(`#${containerId}`);
        container.empty(); // Clear previous content
        container.append('<canvas id="pieChart"></canvas>'); // Add a new canvas

        const ctx = document.getElementById('pieChart').getContext('2d');
        new Chart(ctx, {
            type: 'pie',
            data: {
                labels,
                datasets: [{
                    data,
                    backgroundColor: ['#485778', '#FFF8E6', '#FBDDC5'],
                    hoverBackgroundColor: ['#485778', '#FFF8E6', '#FBDDC5'],
                    borderWidth: 0
                }]
            },
            options: {
                responsive: true,
                plugins: {
                    legend: {
                        position: 'bottom'
                    }
                }
            }
        });
    }

    // Generate Data Table
    function generateTable(containerId, headers, rows) {
        const container = $(`#${containerId}`);
        container.empty(); // Clear previous content

        const table = $('<table></table>').addClass('data-table');
        const thead = $('<thead></thead>');
        const tbody = $('<tbody></tbody>');

        // Generate table headers
        const headerRow = $('<tr></tr>');
        headers.forEach(header => {
            headerRow.append(`<th>${header}</th>`);
        });
        thead.append(headerRow);

        // Generate table rows
        rows.forEach(row => {
            const rowElement = $('<tr></tr>');
            row.forEach(cell => {
                rowElement.append(`<td>${cell}</td>`);
            });
            tbody.append(rowElement);
        });

        table.append(thead).append(tbody);
        container.append(table);
    }

    // Update title dynamically
    function updateTitle(title) {
        $('#header-title').text(title);
    }

    // Update chart title dynamically
    function updateChartTitle(title) {
        $('#chart-title').text(title);
    }

    // Main logic to toggle between Pie Chart and Table
    (async function main() {
        const data = await loadData('weather_data.json'); // Load JSON data

        // Pie Chart Data
        const totalTemperature = data.reduce((sum, item) => sum + item.temperature, 0);
        const totalFeelsLike = data.reduce((sum, item) => sum + item.feels_like, 0);
        const totalWinds = data.reduce((sum, item) => sum + item.winds_mph, 0);

        // Data Table Headers and Rows
        const headers = ['Day', 'Temperature (°C)', 'Humidity (%)', 'Feels Like (°C)', 'Wind Speed (mph)'];
        const rows = data.map(item => [item.day, item.temperature, item.humidity, item.feels_like, item.winds_mph]);

        // Default: Render Pie Chart
        const chartsArea = 'charts-area';
        generatePieChart(chartsArea, ['Temperature', 'Feels Like', 'Wind Speed'], [totalTemperature, totalFeelsLike, totalWinds]);

        // Event listeners for buttons using jQuery
        $('#pieChartSection').on('click', function () {
            generatePieChart(chartsArea, ['Temperature', 'Feels Like', 'Wind Speed'], [totalTemperature, totalFeelsLike, totalWinds]);
            updateTitle('Pie Chart: Weather Data');
            updateChartTitle('Weather Data: Sum of temperature, feels_like and winds_mph');
        });

        $('#tableSection').on('click', function () {
            generateTable(chartsArea, headers, rows);
            updateTitle('Table: Weather Data Details');
            updateChartTitle('Weather Data: Data for all fields');
        });
    })();
});
